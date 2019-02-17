--合成一个set的lua
--retemplate是不是有一个set的api
--lua，0是true，1是false
if ((redis.call('setNx',KEYS[1],ARGV[1]))==1) then
    if (redis.call('get',KEYS[1])==ARGV[1]) then
        return redis.call('expire',KEYS[1],ARGV[2])
    else
        return 0
    end
else
	return 0
end