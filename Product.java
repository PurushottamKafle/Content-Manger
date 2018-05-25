package pksoftFX;

public class Product {
private String name;
 private Double price;
 private int quantity;
 
 // for constructor
 public Product() {
	 this.name="";
	 this.price =0.0;
	 this.quantity=1;
	 
 }
 // PK 
 // making constructor for three parameters
 public Product(String name, Double price, int quantity) {
	 this.name=name;
	 this.price=price;
	 this.quantity=quantity;
	 // finish
 }
 /*
  * PurushottamKafle
  * Todo autogenereatsed
  */
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
 
}
