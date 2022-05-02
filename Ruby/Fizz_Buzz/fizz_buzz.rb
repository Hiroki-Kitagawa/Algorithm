def fizz_buzz(number)
	if number % 15 == 0
		'FizzBuzz'
	elsif number % 3 == 0
		'Fizz'
	elsif number % 5 == 0
		'Buzz'
	else
		number.to_s
	end
end

def join_fizz_buzz(number)
	print_fizz_buzz = ''
	number.times{ |counter|
		counter += 1
		# counterが入力値より大きくなるまで、fizz_buzzの戻り値に「, 」を結合する
		print_fizz_buzz += counter < number ? fizz_buzz(counter) + ', ' : fizz_buzz(counter)
	}
	print_fizz_buzz
end

def input_check(input_number)
	input_number >= 1 ? input_number : input_prompt()
end

def input_prompt
	print '数字を入力してください: '
	input_check(gets.chomp.to_i)
end

# メイン処理
print join_fizz_buzz(input_prompt())
