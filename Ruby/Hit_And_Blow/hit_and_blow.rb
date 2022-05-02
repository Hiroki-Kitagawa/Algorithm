# 入力回数を記録する変数
$input_counter = 1

def judgement_hit_and_blow(rand_array, input)
	# 入力値を数字1桁ごとに分割する
	input_array = input.scan(/\d/)

	if input_array.size > 4
		input_num
	end

	input_array.map!(&:to_i)

	if rand_array == input_array
		# 正解した場合、正解までに要した入力回数を表示する
		$input_counter.to_s + '回で正解！'
	else
		# 外れた場合、Hits(数と桁位置の両方が同じであること)と
		# Blow(数だけが同じで桁位置が異なること)を数える
		hits = 0
		rand_array.size.times{ |n|
			if rand_array[n] == input_array[n]
				hits += 1
			end
		}

		blow = 0
		rand_array.size.times{ |n|
			input_array.size.times{ |m|
				if rand_array[n] == input_array[m] && n != m
					blow += 1
				end
			}
		}
		puts '外れ： ' + hits.to_s + 'Hits, ' + blow.to_s + 'Blow'
		$input_counter += 1
		input = input_num
		judgement_hit_and_blow(rand_array, input)
	end
end

def create_rand_num
	rand(0..9)
end

def create_rand_4_different_digits
	# 各桁が異なる4桁の数字を作成する
	rand_array = []
	rand_array << create_rand_num
	new_rand_num = create_rand_num

	while rand_array.size < 4
		# 4種類の数字が出揃うまで繰り返す
		rand_array.size.times{ |n|
			if ((rand_array.size - 1) == n &&
				rand_array[n] != new_rand_num)
				# rand_arrayの全ての要素を確認し、数字が重複しない場合、new_rand_numの値を追加する
				rand_array << new_rand_num
				new_rand_num = create_rand_num
			elsif rand_array[n] == new_rand_num
				# 数字が重複する場合、new_rand_numを上書きする
				new_rand_num = create_rand_num
			else
				# 数字が重複しないかつ、全ての桁との突合が完了していない場合、new_rand_numを上書きしない
			end
		}
	end
	rand_array
end

def input_num
	puts '4桁の数字は？'
	gets.chomp
end

# メイン処理
rand_array = create_rand_4_different_digits
input = input_num
puts judgement_hit_and_blow(rand_array, input)
