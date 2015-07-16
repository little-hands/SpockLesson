## 概要
このレポジトリは  
2015/7/14開催の勉強会  
「 Groovy+Spock入門ハンズオン - JUnitを卒業して快適テスト生活を始めよう」  
http://d-cube.connpass.com/event/17517/  
のためのハンズオン資料です。

## 事前準備
### JDKのインストール
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html  
環境にあったものをダウンロードしてインストールして下さい。  
(もしくはインストールされていることを確認してください。)

### Eclipseのインストール
Eclipseのバージョンは4.4Lunaを使用します。 
下記のリンクからダウンロード・インストールお願いします。
http://www.eclipse.org/downloads/packages/release/Luna/SR2

ハンズオン中にgroovyを動かすためのプラグインをインストールします。  
環境差異による問題を極力抑えたいため、**必ず上記リンクのEclipseを新規インストール**してください。  
異なる環境の場合、バージョン違いやプラグイン同士の競合などが発生した際には勉強会の時間内に解決できない可能性がありますのでご了承ください。


## 当日ハンズオン向け
### サンプルファイルのインストール
このリポジトリのサンプルファイルをローカル環境にダウンロードしてください。  
git cloneを実行するか、当画面右下の「Download ZIP」からダウンロードしてください。



### Groovy-Eclipseプラグインのインストール
公式ページ  
http://docs.groovy-lang.org/latest/html/documentation/tools-groovyeclipse.html

「Help > Install New Software > Work with」に  
http://dist.springsource.org/release/GRECLIPSE/e4.4  
を入力し、「Groovy-Eclipse」を選択してインストール  
(Eclipse 4.4Luna用のバージョン)

### 講義
(前方のパワーポイント資料をご覧ください)

### 最初のSpockテストコードサンプル

```groovy:HelloSpock.groovy
package test.groovy.lesson

import spock.lang.Specification

class HelloSpock extends Specification {
	def "First Spock Case"() {
		setup: 
		  List list = new ArrayList()
		  String str = "hello spock"
	
		when:
		  list.add(str)
	
		then: 
		  list.size() == 1
		  list.get(0) == str
	  }
}
```


