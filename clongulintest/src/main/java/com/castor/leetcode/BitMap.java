package com.castor.leetcode;

import java.util.BitSet;

public class BitMap {

	private long length;
	private static int[] bitsMap;

	//范围 [0, length)
	public BitMap(long length) {
		this.length = length;
		// 根据长度算出，所需数组大小
		bitsMap = new int[(int) (length >> 5) + ((length & 31) > 0 ? 1 : 0)];
	}

	public int getBit(long index) {
		int intData = bitsMap[(int) (index >> 5)];
		int offset = (int) (index & 31);
		return intData >> offset & 0x01;
	}

	public void setBit(long index) {
		if(index >= length){
			throw new RuntimeException("越界了");
		}
		bitsMap[(int) (index >> 5)] |=  (0x01 << (int) (index & 31));
	}


	public static void main(String[] args) {

		BitMap bitMap = new BitMap(32);
		bitMap.setBit(31);
		System.out.println(bitMap.getBit(1));
		System.out.println(bitMap.getBit(31));






		//0-31
		//32-63
		//64-127
		int key = 65;
    	System.out.println(key >> 5);
    	System.out.println(key & 31);

		/*int [] array = new int [] {1,2,3,22,0,3,63};
		BitSet bitSet  = new BitSet(1);
		System.out.println(bitSet.size());   //64
		bitSet  = new BitSet(65);
		System.out.println(bitSet.size());   //128
		bitSet  = new BitSet(23);
		System.out.println(bitSet.size());   //64

		//将数组内容组bitmap
		for(int i=0;i<array.length;i++)
		{
			bitSet.set(array[i], true);
		}

		System.out.println(bitSet.get(22));
		System.out.println(bitSet.get(60));

		System.out.println("下面开始遍历BitSet：");
		for ( int i = 0; i < bitSet.size(); i++ ){
			System.out.println(bitSet.get(i));
		}*/
	}

}
