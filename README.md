# Algorithm

# Fizz_Buzz仕様
数字を入力し、1から入力値までを「, 」で結合する。

ただし、3の倍数なら「Fizz」、5の倍数なら「Buzz」、15の倍数なら「FizzBuzz」、いずれでもないならその数を出力する。

以下は入出力例である。

入力：15

出力：1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz

# Janken仕様
じゃんけんの手を入力し、コンピューターと対戦する。

以下は入出力例である。

<br>
「じゃんけん・・・」<br>
> 0.グー 1.チョキ 2.パー<br>
1<br>
「ぽい！」<br>
＊コンピュータ：チョキ<br>
＊あなた ：チョキ<br>
「アイコでしょ！」<br>
「じゃんけん・・・」<br>
> 0.グー 1.チョキ 2.パー<br>
2<br>
「ぽい！」<br>
＊コンピュータ：パー<br>
＊あなた ：パー<br>
「アイコでしょ！」<br>
「じゃんけん・・・」<br>
> 0.グー 1.チョキ 2.パー<br>
0<br>
「ぽい！」<br>
＊コンピュータ：パー<br>
＊あなた ：グー<br>
コンピューターの勝ち！<br>

# Recursion仕様
数字を入力し、入力された数字から0までを合計した結果を出力する。

以下は入出力例である。

入力：10

出力：55

# Sort仕様
下記の配列を用いて各要素の合計、平均、最大値、最小値、昇順、降順を出力する。
<br>
[20, 31, 42, 13, 5, 38]

なお、ソートはクイックソート及びバブルソート両方を使うものとする。

例えば、昇順はクイックソート、降順はバブルソートを使うなど。

以下は出力例である。

<br>
合計    : 149
<br>
平均    : 24
<br>
最大値  : 42
<br>
最小値  : 5
<br>
小さい順: 5, 13, 20, 31, 38, 42
<br>
大きい順: 42, 38, 31, 20, 13, 5

# String_Hash仕様
文字列を入力し、入力された文字列に含まれる単語ごとに単語の数を数える。

以下は入出力例である。

入力：a b c a b b

出力：{a: 2, b: 3, c: 1}

# Hi_And_Low仕様
数字を入力し、0-100の範囲で数を当てる。

以下は入出力例である。

入力：50

出力：もっと上

入力：65

出力：もっと下

入力：64

出力：正解！・・・3回目で当てました

# Hit_And_Blow仕様
各桁が異なる4桁の任意な数字と各桁が異なる4桁の入力数字を比較し、一致するまでに要した入力回数を出力する。

以下は入出力例である。

入力：1234

出力：2Hits, 2Blow

入力：2134

出力：1Hits, 3Blow

入力：1324

出力：3回で正解！

# Convert_Hash仕様
hashの中に入った文字列の値"foo"を、"uryyyy!!"に変換する関数を作る。

ただし、hashの中には、hash自体が入れ子構造になっているとする。条件として、入れ子の末端は必ず、"text"をキーとした値が入るようになっている。

入力例を含んだプログラム例：

hash = {
  "main" : {
    "first" : { "text" : "foobar" },
    "second" : { "text" : "fizzbuzz", "child" : { "text" : "foobar" } }
  },
  "sub" : {
    "first" : { "text" : "fizzbuzz", "child" : { "text" : "foobar" } },
    "second" : {
      "third" : { "text" : "barfoo", "child" : { "text" : "foobar" } },
      "forth" : { "child" : { "text" : "jit_foo_foo" } }
    }
  },
  "text" : "foofava"
}

console.log(toUry(hash))

上記の出力例が以下：

{"main":
 {"first":{"text":"uryyyy!!bar"},
  "second":{"text":"fizzbuzz", "child":{"text":"uryyyy!!bar"}}},
"sub":
 {"first":{"text":"fizzbuzz", "child":{"text":"uryyyy!!bar"}},
  "second":
   {"third":{"text":"baruryyyy!!", "child":{"text":"uryyyy!!bar"}},
    "forth":{"child":{"text":"jit_uryyyy!!_uryyyy!!"}}}},
"text":"uryyyy!!fava"}
