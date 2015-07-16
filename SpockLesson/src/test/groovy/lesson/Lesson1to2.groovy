package test.groovy.lesson

import spock.lang.Specification

class Lesson1to2 extends Specification {
	
	// このテストメソッドを「フィーチャメソッド」と呼びます
	def "Lesson1 when・thenブロック"() {
		setup: "準備"
		  List list = new ArrayList()
		  String str = "hello spock"
	
		when: "テストしたい内容の実行"
		  list.add(str)
	
		then: "期待される結果"
		  list.size() == 0
		  list.get(0) == "good night spock"
	  }
	
	def "Lesson2 例外を投げることのAssert"(){
		setup:
		def list = new ArrayList()	//listの定義が"List"ではなく"def"となっている
		  
		when:
		list.get(0)
				
		then:
//		thrown(IndexOutOfBoundsException)
		list.size() == 0
	}
	
	// フィールド（説明上ちょっと気持ち悪い位置に書いていますが）
	// 通常		： フィーチャーメソッド実行ごとに初期化される。
	// @Shared	： フィーチャーメソッド間で共有される
	def sharedStr = "shared String"
	
	
	def "Lesson2 例外を投げないことのAssert"(){
		setup:
		def list = new ArrayList()	//listの定義が"List"ではなく"def"となっている
		  
		when:
//		list.add(sharedStr)
		list.get(0)
				
		then:
		notThrown(IndexOutOfBoundsException)
		list.get(0) == sharedStr
	}
}
