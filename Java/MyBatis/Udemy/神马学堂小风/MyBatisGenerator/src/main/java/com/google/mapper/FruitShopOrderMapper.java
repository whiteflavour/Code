package com.google.mapper;

import com.google.model.FruitShopOrder;
import java.util.List;

public interface FruitShopOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fruit_shop_order
     *
     * @mbg.generated Wed Jun 30 14:51:57 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fruit_shop_order
     *
     * @mbg.generated Wed Jun 30 14:51:57 CST 2021
     */
    int insert(FruitShopOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fruit_shop_order
     *
     * @mbg.generated Wed Jun 30 14:51:57 CST 2021
     */
    FruitShopOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fruit_shop_order
     *
     * @mbg.generated Wed Jun 30 14:51:57 CST 2021
     */
    List<FruitShopOrder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fruit_shop_order
     *
     * @mbg.generated Wed Jun 30 14:51:57 CST 2021
     */
    int updateByPrimaryKey(FruitShopOrder record);
}