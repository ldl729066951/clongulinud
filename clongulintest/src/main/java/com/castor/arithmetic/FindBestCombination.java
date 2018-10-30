package com.castor.arithmetic;

import java.util.*;

/**
 * @author 李默涵
 * On :  18.10.24  16:16
 */
public class FindBestCombination {

	private static long count = 0;

	public static void main( String[] args ) {
		long start = System.currentTimeMillis();
		Double[] array = { 113.61 , 15.2 , 18.952 , 18.951 , 100.0 , 1.050 , 120.01 , 18.950 , 19.9 , 21.12 , 23.88 , 36.67 , 91.31 , 133.45 , 173.7 , 174.0 , 199.0 , 299.0 , 309.0 };
//        Double[] array = { 113.61 , 15.2 , 18.96 , 19.9 , 21.12 , 23.88 , 36.67 , 91.31 , 133.45 , 173.7 , 174.0 , 199.0 , 299.0 , 309.0 };
		List< Double > order = getBestCombination( array , 120.0 );
		long cost = System.currentTimeMillis() - start;
		String result = order == null ? "not exist ." : Arrays.toString( order.toArray() ) + "=" + order.stream().reduce( 0.0 , ( x , y ) -> x + y );
		System.out.println( "cost======>" + cost + "ms \nmost suitable combine is=====>           " + result + "  count = "+ count);
	}

	@SuppressWarnings ( "all" )
	private static List< Double > getBestCombination( Double[] array , final double target ) {
		if ( array.length < 3 ) {
			return null;
		}
		Double[] bigger = Arrays.stream( array ).filter( tar -> tar >= target ).toArray( Double[] ::new );
		Double[] smaller = Arrays.stream( array ).filter( tar -> tar < target ).toArray( Double[] ::new );
		Arrays.sort( bigger );
		List< Double > smallerList = new ArrayList<>( Arrays.asList( smaller ) );
		Double minMax = 0.0;
		if ( bigger.length != 0 ) {
			minMax = bigger[ 0 ];
			if ( minMax == target ) {
				return Arrays.asList( minMax );
			}
			smallerList.add( minMax );
		}
		Map< Double, List< Double > > combines = new HashMap<>( 16 );
		long n = ( long ) Math.pow( 2 , smallerList.size() );
		List< Double > combine;
		for ( long l = 0L ; l < n ; l++ ) {
			combine = new ArrayList<>();
			for ( int i = 0 ; i < smallerList.size() ; i++ ) {
				count++;
				if ( (l >>> i & 1) == 1 ) {
					combine.add( smallerList.get( i ) );
				}
			}
			if ( combine.size() < 2 ) {
				continue;
			}
			Double reduce = combine.stream().reduce( 0.0 , ( x , y ) -> x + y );
			if ( reduce < target ) {
				continue;
			}
			combines.put( reduce , combine );
		}
		if ( combines.size() == 0 ) {
			return null;
		}
		Double result = combines.keySet().stream().filter( key -> key >= target ).sorted().toArray( Double[] ::new )[ 0 ];
		return result > minMax ? Arrays.asList( minMax ) : combines.get( result );
	}
}
