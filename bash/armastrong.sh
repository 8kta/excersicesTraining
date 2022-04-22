# Check if this a nombres is armastrong

size (){
  return `expr length $1`
}

armastrongOp (){
  counter=0
  local number=$1
  local size=$2

  sub=${number:0}
  until [[ $n = $size ]]; do
  #statements
   sub=${sub:0}
  #echo sub
   firstChar=${sub:0:1}
  #echo a sumar $firstChar
   exponent=$(echo $firstChar^$size | bc)
  #echo exponente $exponent
   counter=$(echo $counter+$exponent | bc)
  #echo suma $counter
   ((n++))
   sub=${sub:1}
  done
  return $counter
}

isArmastrong (){
  word=$1
  size $word
  size=$?
  res=$(armastrongOp $word $size)
  if [[ $word==$res ]]; then
    return 0
  else
    return 1
  fi
}

echo Enter a number to check
read number

isArmastrong $number
res=$?
echo $res
