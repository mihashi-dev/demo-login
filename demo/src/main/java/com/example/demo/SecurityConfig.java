package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Securityの設定クラス
 * 
 * <p>
 * 本クラスでは、アプリケーションの認証・認可の設定を行う。
 * アクセス制御、ログイン処理、ログアウト処理などを定義する。
 * </p>
 * 
 * <ul>
 *   <li>ログイン不要ページの指定</li>
 *   <li>ログイン後のリダイレクト設定</li>
 *   <li>ログアウト処理</li>
 *   <li>パスワード暗号化設定</li>
 * </ul>
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
@Configuration
public class SecurityConfig {

	/**
	 * セキュリティフィルタチェーンの設定
	 * 
	 * <p>
	 * 各URLに対するアクセス制御やログイン設定を行う。
	 * </p>
	 * 
	 * @param http HttpSecurityオブジェクト
	 * @return SecurityFilterChain
	 * @throws Exception 例外発生時
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// 認可設定（アクセス制御）
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/login", "/register", "/api/**","/css/**","/js/**").permitAll() // 誰でもアクセス可能
						.anyRequest().authenticated() // それ以外はログイン必須
				)

				// 自動ログイン（Remember Me）
				.rememberMe(me -> me
						.key("secretKey")
						.tokenValiditySeconds(60 * 60 * 24 * 7) // 7日間有効
				)

				// ログイン設定
				.formLogin(form -> form
						.loginPage("/login") // カスタムログイン画面
						.defaultSuccessUrl("/mypage", true) // ログイン成功後
						.permitAll())

				// ログアウト設定
				.logout(logout -> logout
						.logoutSuccessUrl("/login") // ログアウト後の遷移先
						.permitAll())

				// CSRF対策（今回の課題では無効化）
				.csrf(csrf -> csrf.disable());

		return http.build();
	}

	/**
	 * パスワードエンコーダーの設定
	 * 
	 * <p>
	 * BCryptによるパスワードのハッシュ化を行う。
	 * セキュリティ向上のために使用する。
	 * </p>
	 * 
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}