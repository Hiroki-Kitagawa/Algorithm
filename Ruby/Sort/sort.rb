# クイックソート結果格納配列
$pivot_array = []

def sum(num_array)
	num_array.inject(0){ |result, n| result += n }
end

def ave(num_array)
	sum(num_array) / num_array.size
end

def desc_bubbl_sort(num_array)
	# バブルソートの試行回数「n(n - 1)/2」を算出する
	bubble_sort_counter = bubbl_sort_try(num_array.size)

	bubble_sort_counter.times{
		(num_array.size - 1).times{ |n|
			if num_array[n] < num_array[n + 1]
				work_sort = num_array[n]
				num_array[n] = num_array[n + 1]
				num_array[n + 1] = work_sort
			end
		}
	}
	num_array
end

def bubbl_sort_try(size_array)
	(size_array * (size_array - 1) / 2)
end

def asc_quick_sort(num_array)
	# 配列の要素数が1つになるまで比較をしたら、処理を抜ける
	return if num_array.size < 1

	# ソートの軸(pivot)となる値を扱う変数
	pivot = num_array[0]
	# pivotより小さい値を扱う配列
	left_array = []
	# pivotより大きい値を扱う配列
	right_array = []

	(num_array.size - 1).times{ |n|
		if pivot > num_array[n + 1]
			left_array << num_array[n + 1]
		else
			right_array << num_array[n + 1]
		end
	}
	asc_quick_sort(left_array)
	$pivot_array << pivot
	asc_quick_sort(right_array)
	$pivot_array
end

# メイン処理
target_array = [20, 31, 42, 13, 5, 38]
asc_array = asc_quick_sort(target_array)
desc_array = desc_bubbl_sort(target_array)

puts '合計    : ' + sum(target_array).to_s
puts '平均    : ' + ave(target_array).to_s
puts '最大値  : ' + desc_array[0].to_s
puts '最小値  : ' + asc_array[0].to_s
puts '小さい順: ' + asc_array.join(', ').to_s
puts '大きい順: ' + desc_array.join(', ').to_s
