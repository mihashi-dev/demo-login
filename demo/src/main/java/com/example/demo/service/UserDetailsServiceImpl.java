package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

/**
 * ユーザー認証情報を取得するサービスクラス。
 * Spring Securityの認証処理で使用される。
 * 
 * <p>
 * メールアドレスをもとにユーザー情報を取得し、
 * ログイン認証に必要な情報を提供する。
 * </p>
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー情報を取得する
	 *
	 * @param email メールアドレス（ログインID）
	 * @return ユーザー詳細情報
	 * @throws UsernameNotFoundException ユーザーが存在しない場合
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		// メールアドレスをもとにユーザーを取得
		User user = userRepository.findByEmail(email);

		// ユーザーが存在しない場合は例外を投げる
		if (user == null) {
			throw new UsernameNotFoundException("ユーザーが見つかりません");
		}

		// Spring Security用のユーザー情報を生成して返す
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
	}
}