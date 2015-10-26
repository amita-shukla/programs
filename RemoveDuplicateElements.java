/*Suppose you need to remove duplicate elements from an array INPLACE.
	take 2 pointers:
		1st to iterate over the array
		2nd to be incremented only when unique elements are obtained.

*/
class Solution{
public int removeDuplicates(ArrayList<Integer> a) {
	    
	    if(a.size()<2)
	        return a.size();
	        
	   int p=0;
	   for(int q=p+1;q<a.size();q++){
	       if(!a.get(p).equals(a.get(q))){
	           p++;
	           a.set(p,a.get(q));
	       }
	   }
	   return p+1;//this is the length of the new array. Beyond p, there may exist duplicate, invalid elements.
	}
}
/*
In case there is no constraints of an inplace algorithm, Use TreeSet.
LinkedHashSet maintains the order of elements as well.
*/
