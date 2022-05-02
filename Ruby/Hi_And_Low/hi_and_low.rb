# 入力回数を記録する変数
$input_counter = 1

def add_input_counter
	$input_counter += 1
end

def re_enter
	puts '0-100で数字を当てて'
	add_input_counter
	input_number
end

def input_range_check(input)
  input >= 0 && input <= 100 ? input : re_enter
end

def input_number
	input = gets.chomp
  input.scan(/\d+/).size >= 1 ? input_range_check(input.to_i) : re_enter
end

def hi_and_low(rand_num)
	range_confirmed = input_number

	if rand_num == range_confirmed
		puts '正解！・・・' + $input_counter.to_s + '回目で当てました'
	elsif rand_num < range_confirmed
		puts 'もっと下'
		add_input_counter
		hi_and_low(rand_num)
	else
		puts 'もっと上'
		add_input_counter
		hi_and_low(rand_num)
	end
end

# メイン処理
puts '0-100で数字を当てて'
rand_num = rand(0..100)
hi_and_low(rand_num)
