# SampleRetrofit2

サーバ構築からAndroid連携までの簡単手順
通信の種類としてはhttp通信

サーバ側
 - ドメイン追加(バーチャルホスト)
 - niginxの設定
   - バーチャルホストの追加
     - site-availableに追加
     - Inコマンドでsite-enabelに適応
     - nginx再起動
   - バーチャルホスト側のサーバ設定
     - アカウントが無ければ追加
  - 作業スペース(ディレクトリ)確保
    - vitualenvで仮想環境作成
   	- 今後この環境下で作業
    - こうすればsudo権限が要らなくなる
  - PythonのWeb Frame Workのbottleをインストール
    - Webサイトのチュートリアルを見れば最低限起動できる

Android側
 	- プロジェクト作成
 	- gradleにRetrofit2をimpleimentation
  	- Retrofit2はネットワークアクセスライブラリ
  - manifestsにネットワーク権限を追加(`android.permission.INTERNET`)
  - REST(GET,POST等)を追加
  	- 先ずディレクトリ`rest`を追加
   - `rest`内に新規で`RestManager`クラスを作成
   - `rest`内に新規でインターフェースを追加(名前は`システム名+Server`だとわかりやすいかも)
  - 通信するデータ構造の定義
  	- `rest`内に新規でディレクトリ`Pojo`を追加
   	- `Pojo`はPlain Old Java Objectの略
   - 各処理(位置情報を送って画像を返してもらう等)それぞれでディレクトリを作成
   	- その中に`request`、`response`ディレクトリを作成
    - `request`内には`Request+処理名`クラスを作成(`response`も同様)
   - データ形式は`GSON`を使用
   	- GSONは、Googleが提供するJSONデータとJavaオブジェクトを相互に変換するためのライブラリ
  - インターフェース内に関数を定義
  	- データを転送するなら`POST`、受け取るだけなら`GET`等
  - インターフェース内で定義した関数を`RestManager`クラス内で抽象化
  	- つまりRestManager`クラスは抽象クラス
   - RestManager`クラス内でドメインなどを設定

大まかな手順は以上で細かい処理などはググる
