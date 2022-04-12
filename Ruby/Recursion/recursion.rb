$result = 0

def sum(number)
	$result += number

	if number > 0
		sum(number - 1)
	elsif number < 0
		sum(number + 1)
	else
		$result
	end
end

# メイン処理
print '数字を入力してください。入力された数字から0までを合計した結果を出力します。: '
input = gets.chomp
print sum(input.to_i)
