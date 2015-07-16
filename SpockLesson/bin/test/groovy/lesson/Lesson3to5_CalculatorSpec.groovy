package test.groovy.lesson
import main.java.sample.Calculator
import spock.lang.Specification
import spock.lang.Unroll
class Lesson3to5_CalculatorSpec extends Specification {
	
	
	def "Lesson3 (おさらい) when・thenブロック"(){
		setup: "計算機クラスを呼び出す"		// このようにテスト仕様を記述することも可能
		def calculatorLocal = new Calculator()
		
		when: "二つの引数を渡すと"
		def sum = calculatorLocal.calcSum(1, 2)
		
		then: "合計結果を返す"
		sum == 4
	}
	
	
	def "Lesson3 expectブロック データ駆動ではない書き方"(){
		setup:
		def calculatorLocal = new Calculator();
		
		expect:
		calculatorLocal.calcSum(1, 2) == 0
		calculatorLocal.calcSum(1, -3) == 0
		calculatorLocal.calcSum(1, 0)  == 0
	}
	
	/*
	 * 【データ駆動ではないテストの問題点】
	 * ・コードとデータが混在していて、簡単にどちらかを変更できない
	 * ・データを簡単に自動生成したり、外部リソースを読み込んだりできない
	 * ・同じコードを複数回実行する場合は、コードを複製するか別メソッドに抽出をする必要がある
	 * ・実行が失敗した場合、失敗を引き起こした入力値がすぐに分からない
	 * ・コードを複数回実行するために、実行するメソッドを分けるというやり方は、賢いやり方ではない
	 */
	
	// このテスト以降はフィールドで初期化したcalculatorを使用します
	def calculator = new Calculator()
	
	def "Lesson3 expectブロック データ駆動な書き方 データパイプ型"(){
		expect:
		calculator.calcSum(x, y) == sum
	  
		where:
		x 	<< [1,  1, 1]
		y 	<< [2, -3, 0]
		sum << [0,  0, 0]
		
		// Collectionだけでなく、SQLの取得結果、テキストファイルやデータベースなどの外部リソースから取得することも可能！
		// SQLの例	[a, b, c] << sql.rows("select a, b, c from some_table")
		//
	}
	
	def "Lesson3 expectブロック データ駆動な書き方 データテーブル型"(){
		expect:
		calculator.calcSum(x, y) == sum
	  
		where:
		x	|y	 ||sum
		2	|4	 ||0
		3	|-6	 ||0
	}
	
	def "Lesson4 おまけ さらに複雑な計算過程のログ"(){
		expect:
		calculator.calcSum(a, b) + calculator.calcSum(c, d) == e

		where:
		a	|b	|c	|d	||e
		1	|2	|3	|4	||9
		
	}
	
//	@Unroll
	def "Lesson5 メソッド名にパラメータを ： #x と #y の合計"(){
		expect:
		calculator.calcSum(x, y) == sum
	  
		where: 
		x	|y	 ||sum
		2	|4	 ||0
		3	|-6	 ||0
		4	|0	 ||0
	}
	
	/*
	 * その他のビルトイン拡張機能
	 */
	// @Unroll		: 結果をまとめずに表示する
	// @Ignore		: アノテーションをつけたメソッド/クラスを実行停止
	// @IngoreRest	: アノテーションをつけた以外のメソッド/クラスを実行停止
	// @IgnoreIf	: 特定の条件下でのみメソッドをignoreする
	//				例：@IgnoreIf({ os.windows })
	// @Requires	: 特定の条件下でのみメソッドを実行する
	//				例：@Requires({ os.windows })
	//				→IgnoreIfの逆。一般的には、ignoreする条件を記述するよりも、メソッドを実行する条件を明示する方が、良い作法とされています。
	
	/* 
	 * フィクスチャーメソッド
	 */
	// メソッド名				 概要								JUnitで言うと
	// def setup(){}		: 各フィーチャーメソッド実行前に実行		@Before
	// def cleanup(){}		: 各フィーチャーメソッド実行後に実行		@After
	// def setupSpec(){}	: 最初のフィーチャーメソッド実行前に実行		@BeforeClass
	// def cleanupSpec(){}	: 最後のフィーチャーメソッド実行後に実行		@AfterClass
	
	/*
	 * その他、JUnitとの対応の整理
	 */
	// Spockでは					JUnitでは
	// Specification			Test class
	// Feature					Test
	// Parametarized feature	Theory
	// Condition				Assertion
	// Exception condition		@Test(expected=...)
	// @FailsWith				@Test(expected=...)
	// Interaction				Mock expecation (EasyMock, JMock, ...)
	
	/*
	 * その他拡張
	 */
	// spock-spring		: Springと共存 プロジェクトで使っているDIがそのまま使える
	// Geb				: ブラウザテスト自動化
	
}
