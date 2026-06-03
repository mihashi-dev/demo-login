package com.example.demo;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 画面遷移を制御するコントローラクラス
 * 
 * <p>
 * 本クラスは、各URLに対するリクエストを受け取り、
 * 対応する画面（HTMLテンプレート）へ遷移させる役割を持つ。
 * </p>
 * 
 * <ul>
 *   <li>/login : ログイン画面</li>
 *   <li>/admin : 管理画面</li>
 *   <li>/register : 登録画面</li>
 *   <li>/mypage : マイページ</li>
 *   <li>/logout : ログアウト処理</li>
 * </ul>
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
@Controller
public class HelloController {

	/**
	 * ログイン画面を表示する
	 * 
	 * @return login画面（login.html）
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 管理画面を表示する
	 * 
	 * @return admin画面（admin.html）
	 */
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	/**
	 * ユーザー登録画面を表示する
	 * 
	 * @return register画面（register.html）
	 */
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	/**
	 * ログアウト処理を行う
	 * 
	 * <p>
	 * セッションを無効化し、ログイン画面へリダイレクトする。
	 * </p>
	 * 
	 * @param session HTTPセッション
	 * @return ログイン画面へリダイレクト
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	/**
	 * マイページを表示する
	 * 
	 * @return mypage画面（mypage.html）
	 */
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}