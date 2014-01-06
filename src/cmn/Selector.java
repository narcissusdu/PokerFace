package cmn;

import java.util.ArrayList;

public class Selector<T> {
	public ArrayList<ArrayList<T>> Select(ArrayList<T> list, int count)
			throws Exception {

		if (count > list.size())
			throw new Exception(
					"size of array should be not smaller than count");

		ArrayList<ArrayList<T>> result = new ArrayList<ArrayList<T>>();

		// simulation of the pointers.
		int[] pointers = new int[count];

		// set up the initial state of the pointers
		// make sure the pointers are working in increasing order
		for (int i = 0; i < count; i++)
			pointers[i] = i;

		int workPointer = count - 1;

		while (pointers[0] != list.size() - count) {

			// the sequence of the elements must not be changed in this method
			result.add(buildArray(list, pointers));

			// save the state of the work-pointer in order to notice that
			// it has been move left after the calculation
			int lastPointer = workPointer;

			// find out which pointer should be moved left
			workPointer = getcurrentWorkPointer(list.size(), pointers);
			pointers[workPointer]++;

			// reset the positions of pointers right to the work-pointer
			if (lastPointer > workPointer)
				for (int i = workPointer + 1; i < count; i++)
					pointers[i] = pointers[i - 1] + 1;
		}

		result.add(buildArray(list, pointers));

		return result;
	}

	public ArrayList<T> buildArray(ArrayList<T> list, int[] pointers) {
		ArrayList<T> resultList = new ArrayList<T>();
		for (int i = 0; i < pointers.length; i++) {
			resultList.add(list.get(pointers[i]));
		}
		return resultList;
	}

	private int getcurrentWorkPointer(int arrayLength, int[] pointers) {
		int workPointer = pointers.length - 1;
		if (pointers[workPointer] < arrayLength - 1)
			return workPointer;
		for (; pointers[workPointer - 1] == pointers[workPointer] - 1; workPointer--)
			;
		return workPointer - 1;
	}
}
