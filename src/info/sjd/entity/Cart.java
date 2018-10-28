package info.sjd.entity;

public class Cart {

	private Integer cartId;
	private Long creationTime;
	private String userLogin;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	
}
