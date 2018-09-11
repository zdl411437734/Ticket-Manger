package com.account.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculateTool {


    /**
     * @author Ragty
     * @param 贴现金额计算
     * @serialData 2018.8.21
     * @param day
     * @param rate
     * @param ticketAmount
     * @return
     */
    public String calculateDiscount(long day,Float rate,Float ticketAmount){

        BigDecimal da = new BigDecimal(day+"");
        BigDecimal ra = new BigDecimal(rate.toString());
        BigDecimal ta = new BigDecimal(ticketAmount.toString());
        BigDecimal bd = new BigDecimal("36000");
        //贴现利息
        BigDecimal discountInterest = ra.multiply(da).multiply(ta).divide(bd,4,BigDecimal.ROUND_HALF_UP);

        //贴现金额
        BigDecimal discountAmount = ta.subtract(discountInterest);

        return discountAmount.toString();
    }


    /**
     * @author Ragty
     * @param  根据不同产品计算不同的收益
     * @serialData 2018.8.24
     * @param discount
     * @param productDays
     * @param day
     * @param yield
     * @return
     */
    public String productIncome(String discount,Long productDays,Long day,Float yield ){

        //不同产品的理财次数
        Long productNumber = day/productDays;

        BigDecimal pd = new BigDecimal(productNumber.toString());
        BigDecimal pdd = new BigDecimal(productDays.toString());
        BigDecimal dis = new BigDecimal(discount);
        BigDecimal yie = new BigDecimal(yield.toString());
        BigDecimal md  = new BigDecimal("36500");

        //单次预估值
        BigDecimal income = dis.multiply(yie).multiply(pdd).divide(md,4,BigDecimal.ROUND_HALF_UP);

        //理财预估收益
        BigDecimal prductIncome = income.multiply(pd);

        return prductIncome.toString();
    }



}
