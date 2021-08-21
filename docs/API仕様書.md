# API仕様書

## 1. Expenses

### 1.1 全件取得

|||
| --- | --- |
| URI | /expenses |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<ExpenseListItem\>) |

### 1.2 詳細取得

|||
| --- | --- |
| URI | /expenses/{id} |
| メソッド | GET |
| パスパラメータ | id: expenseId |
| リクエストボディ | - |
| レスポンス| 200 OK (ExpenseDetail), 404 Not Found : {id}が存在しない |

### 1.3 新規作成

|||
| --- | --- |
| URI | /expenses/create |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | ExpenseDetail |
| レスポンス| 200 OK |

### 1.4 更新

|||
| --- | --- |
| URI | /expenses/update |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | ExpenseDetail |
| レスポンス| 200 OK, 404 Not Found : 支出IDが存在しない |

### 1.5 削除

|||
| --- | --- |
| URI | /expenses/delete/{id} |
| メソッド | DELETE |
| パスパラメータ | id: expenseId |
| リクエストボディ | - |
| レスポンス| 200 OK, 404 Not Found : {id}が存在しない |

### 1.6 決済方法をもとに取得

|||
| --- | --- |
| URI | /expenses/payment/{id} |
| メソッド | GET |
| パスパラメータ | id: paymentId |
| リクエストボディ | - |
| レスポンス| 200 OK (List<ExpenseListItem\>) |

### 1.7 店舗をもとに取得

|||
| --- | --- |
| URI | /expenses/store/{id} |
| メソッド | GET |
| パスパラメータ | id: storeId |
| リクエストボディ | - |
| レスポンス| 200 OK (List<ExpenseListItem\>) |

### 1.8 決済方法ごとの金額を取得

|||
| --- | --- |
| URI | /expenses/payment/totals |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<TotalEachFilter\>) |

### 1.9 店舗ごとの金額を取得

|||
| --- | --- |
| URI | /expenses/store/totals |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<TotalEachFilter\>) |

## 2. Items

### 2.1 カテゴリをもとに取得

|||
| --- | --- |
| URI | /items/category/{id} |
| メソッド | GET |
| パスパラメータ | id: categoryId |
| リクエストボディ | - |
| レスポンス| 200 OK (List<ItemListItem\>) |

### 2.2 カテゴリごとの金額を取得

|||
| --- | --- |
| URI | /items/category/totals |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<TotalEachFilter\>) |

## 3. Categories

### 3.1 全件取得

|||
| --- | --- |
| URI | /categories |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Filter\>) |

### 3.2 新規作成

|||
| --- | --- |
| URI | /categories/create |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | String |
| レスポンス| 200 OK |

### 3.3 更新

|||
| --- | --- |
| URI | /categories/update |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Filter |
| レスポンス| 200 OK, 404 Not Found : カテゴリIDが存在しない |

### 3.4 削除

|||
| --- | --- |
| URI | /categories/delete/{id} |
| メソッド | DELETE |
| パスパラメータ | id: categoryId |
| リクエストボディ | - |
| レスポンス| 200 OK, 404 Not Found : {id}が存在しない |
| 備考 | 指定したカテゴリIDを持つitemsのレコードも削除される |

## 4. Payments

### 4.1 全件取得

|||
| --- | --- |
| URI | /payments |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Filter\>) |

### 4.2 新規作成

|||
| --- | --- |
| URI | /payments/create |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | String |
| レスポンス| 200 OK |

### 4.3 更新

|||
| --- | --- |
| URI | /payments/update |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Filter |
| レスポンス| 200 OK, 404 Not Found : 決済方法IDが存在しない |

### 4.4 削除

|||
| --- | --- |
| URI | /payments/delete/{id} |
| メソッド | DELETE |
| パスパラメータ | id: paymentId |
| リクエストボディ | - |
| レスポンス| 200 OK, 404 Not Found : {id}が存在しない |
| 備考 | 指定した決済方法IDを持つexpense_paymentsのレコードも削除される |

## 5. Stores

### 5.1 全件取得

|||
| --- | --- |
| URI | /stores |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Filter\>) |

### 5.2 新規作成

|||
| --- | --- |
| URI | /stores/create |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | String |
| レスポンス| 200 OK |

### 5.3 更新

|||
| --- | --- |
| URI | /stores/update |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Filter |
| レスポンス| 200 OK, 404 Not Found : 店舗IDが存在しない |

### 5.4 削除

|||
| --- | --- |
| URI | /stores/delete/{id} |
| メソッド | DELETE |
| パスパラメータ | id: storeId |
| リクエストボディ | - |
| レスポンス| 200 OK, 404 Not Found : {id}が存在しない |
| 備考 | 指定した店舗IDを持つexpensesのレコードも削除される |
