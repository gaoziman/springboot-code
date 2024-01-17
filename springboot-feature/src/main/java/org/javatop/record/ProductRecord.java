package org.javatop.record;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-17 14:28
 * @description :
 */
public record ProductRecord(String id, String name, Integer qty) implements PrintInterface {

    @Override
    public void print() {
        String productDesc = String.join("---", id, name, qty.toString());
        System.out.println("商品信息 : " + productDesc);
    }

    public static void main(String[] args) {
//        ProductRecord product = new ProductRecord("P001", "手机", 100);
//        product.print();

        //定义 Java Record
        record SaleRecord(String saleId, String productName, Double money) {
        }
        ;//创建 Local Record
        SaleRecord saleRecord = new SaleRecord("S22020301", "手机", 3000.0);//使用 SaleRecord
        System.out.println("销售记录 = " + saleRecord.toString());
    }
}
