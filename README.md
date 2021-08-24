# My money

## What?

家計簿アプリ「My money」のAPI担当
アプリの詳細は[Androidのリポジトリ](https://github.com/tyty96/AccountBookForMe_android)にて

### Contains

|- app: APIサーバー本体
|- docker: DB
|- docs: ドキュメント（API仕様書、設計書）
|- .gitignore
|- README: Here

## How?

### 動作環境

* Java 11
* Springboot 2.1.1
* Gradle 6.8.2
* Lombok
* Liquibase
* MySQL 5.7

### IDE

* EclipseまたはSTS

### 環境構築

1. ローカルにクローン

   ```zsh
   git clone https://github.com/tyty96/AccountBookForMe_server.git
   ```

2. Eclipseに「既存のGradleプロジェクト」としてインポート
3. DockerでMySQL起動

    ```zsh
    docker-compose up -d
    ```

4. EclipseでSpring boot Appとして起動
5. APIを叩いてみて返ってきたらOK