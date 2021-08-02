package com.example.AccountBookForMe.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExpenseDetail extends ExpenseListItem {

    private Long storeId = null;

    private String note = null;
	
    private List<ItemListItem> itemList;
	
    private List<PaymentListItem> paymentList;

}
