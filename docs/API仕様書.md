# API仕様書

## 1. Expenses

### 1.1 全件取得

|||
| --- | --- |
| URI | /expenses |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Expense\>) |

### 1.2 1件取得

|||
| --- | --- |
| URI | /expenses/{id} |
| メソッド | GET |
| パスパラメータ | id: expenseId |
| リクエストボディ | - |
| レスポンス| 200 OK (Expense : List<Item\>付き), 400 Bad Request : {id}が存在しない |

### 1.3 新規作成

|||
| --- | --- |
| URI | /expenses |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Expense : List<Item\>付き |
| レスポンス| 200 OK |

### 1.4 更新

|||
| --- | --- |
| URI | /expenses/{id} |
| メソッド | PUT |
| パスパラメータ | id: expenseId |
| リクエストボディ | Expense : List<Item\>付き |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 1.5 削除

|||
| --- | --- |
| URI | /expenses/{id} |
| メソッド | DELETE |
| パスパラメータ | id: expenseId |
| リクエストボディ | - |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 1.6 決済方法をもとに取得

|||
| --- | --- |
| URI | /expenses/category/{id} |
| メソッド | GET |
| パスパラメータ | id: categoryId |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Expense\>), 400 Bad Request : {id}が存在しない |

### 1.7 店舗をもとに取得

|||
| --- | --- |
| URI | /expenses/store/{id} |
| メソッド | GET |
| パスパラメータ | id: storeId |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Expense\>), 400 Bad Request : {id}が存在しない |

## 2. Items

### 2.1 更新

|||
| --- | --- |
| URI | /items/{id} |
| メソッド | PUT |
| パスパラメータ | id: itemId |
| リクエストボディ | Item |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 2.2 削除

|||
| --- | --- |
| URI | /items/{id} |
| メソッド | DELETE |
| パスパラメータ | id: itemId |
| リクエストボディ | - |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 2.3 カテゴリをもとに取得

|||
| --- | --- |
| URI | /items/category/{id} |
| メソッド | GET |
| パスパラメータ | id: categoryId |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Item\>), 400 Bad Request : {id}が存在しない |

## 3. Categories

### 3.1 全件取得

|||
| --- | --- |
| URI | /categories |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Category\>) |

### 2.2 1件取得

|||
| --- | --- |
| URI | /categories/{id} |
| メソッド | GET |
| パスパラメータ | id: categoryId |
| リクエストボディ | - |
| レスポンス| 200 OK (Category), 400 Bad Request : {id}が存在しない |

### 3.3 新規作成

|||
| --- | --- |
| URI | /categories |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Category |
| レスポンス| 200 OK |

### 3.4 更新

|||
| --- | --- |
| URI | /categories/{id} |
| メソッド | PUT |
| パスパラメータ | id: categoryId |
| リクエストボディ | Category |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 3.5 削除

|||
| --- | --- |
| URI | /categories/{id} |
| メソッド | DELETE |
| パスパラメータ | id: categoryId |
| リクエストボディ | - |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

## 4. Payments

### 4.1 全件取得

|||
| --- | --- |
| URI | /payments |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Payment\>) |

### 4.2 1件取得

|||
| --- | --- |
| URI | /payments/{id} |
| メソッド | GET |
| パスパラメータ | id: paymentId |
| リクエストボディ | - |
| レスポンス| 200 OK (Payment), 400 Bad Request : {id}が存在しない |

### 4.3 新規作成

|||
| --- | --- |
| URI | /payments |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Payment |
| レスポンス| 200 OK |

### 4.4 更新

|||
| --- | --- |
| URI | /payments/{id} |
| メソッド | PUT |
| パスパラメータ | id: paymentId |
| リクエストボディ | Payment |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 4.5 削除

|||
| --- | --- |
| URI | /payments/{id} |
| メソッド | DELETE |
| パスパラメータ | id: paymentId |
| リクエストボディ | - |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

## 5. Stores

### 5.1 全件取得

|||
| --- | --- |
| URI | /stores |
| メソッド | GET |
| パスパラメータ | - |
| リクエストボディ | - |
| レスポンス| 200 OK (List<Store\>) |

### 5.2 1件取得

|||
| --- | --- |
| URI | /stores/{id} |
| メソッド | GET |
| パスパラメータ | id: storeId |
| リクエストボディ | - |
| レスポンス| 200 OK (Store), 400 Bad Request : {id}が存在しない |

### 5.3 新規作成

|||
| --- | --- |
| URI | /stores |
| メソッド | PUT |
| パスパラメータ | - |
| リクエストボディ | Store |
| レスポンス| 200 OK |

### 5.4 更新

|||
| --- | --- |
| URI | /stores/{id} |
| メソッド | PUT |
| パスパラメータ | id: storeId |
| リクエストボディ | Store |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |

### 5.5 削除

|||
| --- | --- |
| URI | /stores/{id} |
| メソッド | DELETE |
| パスパラメータ | id: storeId |
| リクエストボディ | - |
| レスポンス| 200 OK, 400 Bad Request : {id}が存在しない |
