package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	
	private String email;
	private String username;
	private String password;
	private Date lastLogin;
	private int userId;
	private boolean admin;
	
	private static final long serialVersionUID = 1L;
	
	private List<Product> productHistory;
	
	private static int generateId = 0;
	
	public User(String email, String username,String password, boolean admin) {
		this.userId = ++User.generateId;
		this.email = email;
		this.username = username;
		this.password = password;
		this.admin = admin;
		lastLogin = new Date();
		productHistory = new ArrayList<Product>();
	}
	
	public User() {
		this.userId = ++User.generateId;
		lastLogin = new Date();
		productHistory = new ArrayList<Product>();
	}
	
	public void copyUser(User another) {
		this.userId = another.getUserId();
		this.username = another.getUsername();
		this.password = another.getPassword();
		this.lastLogin = another.getLastLogin();
		this.admin = another.isAdmin();
		this.productHistory = another.getProductHistory();
	}
	
	/**
	 * User can buy an amount of products.
	 * 
	 * @param productToBuy
	 * @param amount
	 */
	public void buyProduct(Product productToBuy, int amount) {
		//TODO: implement availableStock to know if i can buy an amount of products.
		productToBuy.setProductStock(productToBuy.getProductStock() - amount);
		Product copy = new Product();
		copy.copyProduct(productToBuy);
		copy.setProductStock(amount);
		productHistory.add(copy);
	}
	
	/**
	 * User can buy one product.
	 * 
	 * @param productToBuy
	 */
	public void buyProduct(Product productToBuy) {
		this.buyProduct(productToBuy, 1);
	}
	
	/**
	 * Return true if User have bought the same product.
	 * 
	 * @param product
	 * @return
	 */
	public boolean containsProduct(Product product) {
		boolean contain = false;
		for(int i = 0; i < productHistory.size(); i++) {
			if(product.compareProduct(productHistory.get(i))) {
				contain = true;
				break;
			}
		}
		return contain;
	}
	
	public Product getProductFromHistory(int index) {
		return productHistory.get(index);
	}

	public List<Product> getProductHistory() {
		return this.productHistory;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin() {
		this.lastLogin = new Date();
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getUserId() {
		return userId;
	}
/*
 * This method returns the email, the user, the password and recognizes if it is administrator or not
 */
	@Override
	public String toString() {
		return email + ";" + username + ";" + password + ";" + admin;
	}
}
