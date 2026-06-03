package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * ユーザー情報を管理するRESTコントローラクラス。
 * CRUD（作成・取得・更新・削除）機能を提供する。
 * 
 * @author 三橋雄大
 * @version 1.0
 * @since 2026/06/03
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * ユーザー一覧を取得する。
	 * 名前を指定した場合は部分一致検索を行う。
	 *
	 * @param name 検索対象の名前（任意）
	 * @return ユーザー一覧
	 */
	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(required = false) String name) {
		if (name != null && !name.isEmpty()) {
			return userRepository.findByNameContaining(name);
		}
		return userRepository.findAll();
	}

	/**
	 * ユーザーを新規登録する。
	 * パスワードは暗号化して保存する。
	 *
	 * @param user 登録するユーザー情報
	 * @return 登録後のユーザー情報
	 */
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	/**
	 * ユーザー情報を更新する。
	 *
	 * @param id 更新対象のユーザーID
	 * @param newUser 新しいユーザー情報
	 * @return 更新後のユーザー情報
	 */
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));

		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());

		return userRepository.save(user);
	}

	/**
	 * ユーザーを削除する。
	 *
	 * @param id 削除対象のユーザーID
	 */
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}