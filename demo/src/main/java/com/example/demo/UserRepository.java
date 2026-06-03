package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * ユーザー情報を操作するリポジトリインターフェース。
 * データベース（usersテーブル）へのアクセスを担当する。
 * 
 * <p>
 * Spring Data JPAを使用しており、
 * 基本的なCRUD処理は自動で提供される。
 * </p>
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * ユーザー名による部分一致検索を行う
	 *
	 * @param name 検索する名前
	 * @return 該当するユーザー一覧
	 */
	List<User> findByNameContaining(String name);

	/**
	 * メールアドレスからユーザーを取得する（ログイン認証用）
	 *
	 * @param email メールアドレス
	 * @return ユーザー情報（見つからない場合はnull）
	 */
	User findByEmail(String email);
}