package com.hui.Top150;

import java.util.*;

public class RandomizaedSet380 {
    public static void main(String[] args) {
           //初始化，insert1, remove2,insert2,getRandom,remove1,insert2,getRandom
           // null,T,F,T,2,T,F,2
        RandomizaedSet380 randomizaedSet380 = new RandomizaedSet380();
        System.out.println(randomizaedSet380.insert(1));
        System.out.println(randomizaedSet380.remove(2));
        System.out.println(randomizaedSet380.insert(2));
        System.out.println(randomizaedSet380.getRandom());
        System.out.println(randomizaedSet380.remove(1));
        System.out.println(randomizaedSet380.insert(2));
        System.out.println(randomizaedSet380.getRandom());
    }
    List<Integer> randomList = null;
    Map<Integer,Integer> randomMap = null;
    Random random = null;
    public RandomizaedSet380() {
        random = new Random();
        randomList = new ArrayList<>();
        randomMap = new HashMap<>();
    }

    public boolean insert(int val){
        if(randomMap.containsKey(val)){
            return false;
        }
        randomList.add(val);
        randomMap.put(val,randomList.size()-1);
        return true;
    }
    public boolean remove(int val){
        if(!randomMap.containsKey(val)){
            return false;
        }
        int last = randomList.get(randomList.size()-1);
        int valIndex = randomMap.get(val);
        // 将最后一个元素设置在之前元素的索引位置
        randomList.set(valIndex,last);
        randomMap.put(last,valIndex);
        //　把最后一个元素移除
        randomList.remove(randomList.size()-1);
        randomMap.remove(val);
        return true;
    }

    public int getRandom(){
        int randomIndex = random.nextInt(randomList.size());
        return randomList.get(randomIndex);
    }
}
