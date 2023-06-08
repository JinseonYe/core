package hello.core.order;

public class Order {

	// 주문 다 하고 나면 만들어지는 객체
	private Long memberId;
	private String itemName;
	private int itemPrice;
	private int discountPrice;

	public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
		this.memberId = memberId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discountPrice = discountPrice;
	}

	// 계산 로직
	// 최종 계산된 가격을 알려주는 메소드
	public int calculatePrice() {
		return itemPrice - discountPrice;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getDicountPrice() {
		return discountPrice;
	}

	public void setDicountPrice(int dicountPrice) {
		this.discountPrice = dicountPrice;
	}

	// 객체를 출력하면 toString 결과가 쭉 나온다.
	@Override
	public String toString() {
		return "Order{" +
			"memberId=" + memberId +
			", itemName='" + itemName + '\'' +
			", itemPrice=" + itemPrice +
			", discountPrice=" + discountPrice +
			'}';

		// System.out.println("Order = " + Order);
		// 상단코드 출력 시 위에 toString처럼 보기 편하게 하기 위함
	}
}
