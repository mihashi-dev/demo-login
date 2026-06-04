package com.example.demo.entity;

import jakarta.persistence.*;

/**
 * ユーザー情報を管理するエンティティクラス。
 * usersテーブルに対応する。
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** ユーザー名（必須） */
	@Column(nullable = false)
	private String name;

	/** メールアドレス（必須・一意） */
	@Column(nullable = false, unique = true)
	private String email;

	/** パスワード（ハッシュ化して保存） */
	@Column(nullable = false)
	private String password;

	/**
	 * ユーザーIDを取得する
	 * 
	 * @return ユーザーID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * ユーザーIDを設定する
	 * 
	 * @param id ユーザーID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * ユーザー名を取得する
	 * 
	 * @return ユーザー名
	 */
	public String getName() {
		return name;
	}

	/**
	 * ユーザー名を設定する
	 * 
	 * @param name ユーザー名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * メールアドレスを取得する
	 * 
	 * @return メールアドレス
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * メールアドレスを設定する
	 * 
	 * @param email メールアドレス
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * パスワードを取得する
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する
	 * 
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}