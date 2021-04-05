package top.lixiang007.po;

import java.util.List;

/**
 * 订单持久化类
 */
public class Orders {
	private Integer id;    //订单id
	private String number;//订单编号


//	public Customer getCustomer1() {
//		return customer1;
//	}
//
//	public void setCustomer1(Customer customer1) {
//		this.customer1 = customer1;
//	}
//
//	private Customer customer1;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", number=" + number + "]";
	}
}

