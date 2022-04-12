def start_janken
	puts '「じゃんけん・・・」'
	puts '> 0.グー 1.チョキ 2.パー'
	input = gets.chomp.to_i
	# 入力値が期待値(0, 1, 2)通りか判定
	if (input != 0 &&
		input != 1 &&
		input != 2)
		# 期待通りでない場合、やり直し
		puts '入力値は「0, 1, 2」のいずれかを入力してください'
		start_janken
	else
		# 期待通りの場合、じゃんけんの勝敗を決める
		judgement_janken(input)
	end
end

def judgement_janken(player_idx)
	janken = ['グー', 'チョキ', 'パー']

	# プレイヤーの手
	player_hand = janken[player_idx]

	# コンピューターの手
	comp_idx = rand(0..2)
	comp_hand = janken[comp_idx]

	# 結果を表示
	puts '「ぽい！」'
	puts '＊コンピュータ：' + comp_hand
	puts '＊あなた ：' + player_hand
	if player_hand == comp_hand
		puts '「アイコでしょ！」'
		start_janken
	elsif (player_hand == janken[0] && comp_hand == janken[1] ||
				 player_hand == janken[1] && comp_hand == janken[2] ||
				 player_hand == janken[2] && comp_hand == janken[0])
		puts '「あなたの勝ち！」'
	else
		puts 'コンピューターの勝ち！'
	end
end

# メイン処理
start_janken
