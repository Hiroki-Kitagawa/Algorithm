def edit_output(found_word)
	# 出力形式(単語: 単語数)に編集する
	edit_word = []
	edit_word << found_word[0] + ': ' + found_word.size.to_s
end

def word_count(word)
	result = []
	array_words = word.split(' ')
	# 見つかった単語を配列から削除するため、要素数が0になるまで処理を行う
	array_words.size.times{
		# 先頭要素と同じ単語が配列内にあるか調べる
		found_word = array_words.find_all{ |find_word|
			find_word == array_words[0]
		}

		# 見つかった単語を出力形式に編集する
		result << edit_output(found_word)

		# 見つかった単語を削除する
		array_words.delete(found_word[0])

		# array_wordsが空だったら、処理を抜ける
		break if array_words.size < 1
	}
	result
end

# メイン処理
print '文字列を入力してください。文字列に含まれる単語の数を、単語ごとに数えます: '
input = gets.chomp
print '{' + word_count(input.to_s).join(', ') + '}'
