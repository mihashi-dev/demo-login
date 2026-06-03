package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * アプリケーションのエントリーポイントクラス
 * 
 * <p>
 * 本クラスはSpring Bootアプリケーションの起動を行う。
 * @SpringBootApplicationアノテーションにより、
 * 以下の設定が自動的に有効化される。
 * </p>
 * 
 * <ul>
 *   <li>自動設定（Auto Configuration）</li>
 *   <li>コンポーネントスキャン（Component Scan）</li>
 *   <li>設定クラスの定義（Configuration）</li>
 * </ul>
 * 
 * <p>
 * 通常、本クラスはプロジェクトのルートパッケージに配置し、
 * 配下のクラスがスキャン対象となるようにする。
 * </p>
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * メインメソッド
	 * 
	 * <p>
	 * Spring Bootアプリケーションを起動するためのエントリーポイント。
	 * SpringApplication.run() により、Springコンテナを起動し、
	 * Webサーバ（デフォルトではTomcat）を立ち上げる。
	 * </p>
	 * 
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}