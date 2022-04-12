# 入れ子の末端のキー名称「text」
KEY_TEXT = 'text'

def toUry(before_conversion_hash)
	before_conversion_hash.each do |key, value|
    # 入れ子の末端と合致する場合、「foo」を「uryyyy!!」に変換する。合致しない場合、現在の入れ子を引数にtoUryメソッドを呼び出す
    key == KEY_TEXT ? value.gsub!('foo', 'uryyyy!!') : toUry(value)
	end
end

# メイン処理
before_conversion_hash =
{
	'main' => {
		'first' => {'text' => 'foobar'},
		'second' => {'text' => 'fizzbuzz', 'child' => {'text' => 'foobar'}}
	},
	'sub' => {
		'first' => {'text' => 'fizzbuzz', 'child' => {'text' => 'foobar'}},
		'second' => {
			'third' => {'text' => 'barfoo', 'child' => {'text' => 'foobar'}},
			'forth' => {'child' => {'text' => 'jit_foo_foo'}}
		}
	},
	'text' => 'foofava'
}
puts toUry(before_conversion_hash)
