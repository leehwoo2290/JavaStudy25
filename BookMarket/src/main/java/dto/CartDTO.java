package dto;

public class CartDTO {

	private String c_accountId;
	private String c_bookId;
	private int c_unitPrice;
	private int c_amount;
	
	
	public String getC_accountId() {
		return c_accountId;
	}
	public void setC_accountId(String c_accountId) {
		this.c_accountId = c_accountId;
	}
	public String getC_bookId() {
		return c_bookId;
	}
	public void setC_bookId(String c_bookId) {
		this.c_bookId = c_bookId;
	}
	public int getC_unitPrice() {
		return c_unitPrice;
	}
	public void setC_unitPrice(int c_unitPrice) {
		this.c_unitPrice = c_unitPrice;
	}
	public int getC_amount() {
		return c_amount;
	}
	public void setC_amount(int c_amount) {
		this.c_amount = c_amount;
	}
}
