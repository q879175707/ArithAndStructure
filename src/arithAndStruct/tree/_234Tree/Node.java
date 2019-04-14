package arithAndStruct.tree._234Tree;

public class Node {

	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER - 1];

	/**
	 * connect child to this node
	 * 
	 * @param childNum the array number of child to connect
	 * @param child    the element of child
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * disconnect child from this node, and return it
	 * 
	 * @param childNum
	 * @return
	 */
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	/**
	 * 返回指定索引处的子节点。
	 * @param childNum
	 * @return
	 */
	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	/**
	 * 返回当前节点的父节点
	 * @return
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * 是否是叶节点，是返回true，不是，返回false
	 * @return
	 */
	public boolean isLeaf() {
		return childArray[0] == null ? true : false;
	}

	/**
	 * 返回当前节点的数据项的数量
	 * @return
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * 根据数据数组索引，取出对应的数据
	 * @param index
	 * @return
	 */
	public DataItem getItem(int index) {
		return itemArray[index];
	}

	/**
	 * 判断当前节点是不是满节点
	 * @return
	 */
	public boolean isFull() {
		return numItems == ORDER - 1 ? true : false;
	}

	/**
	 * 根据关键字key找到在节点数据项数组中的数据，返回key所在数组的索引。
	 * 如果没有找到返回-1
	 * @param key
	 * @return
	 */
	public int findItem(long key) {
		for (int j = 0; j < ORDER - 1; j++) {
			if (itemArray[j] == null)
				break;
			else if (itemArray[j].dData == key)
				return j;
		}
		return -1;
	}

	/**
	 * 插入数据项，并且使数据项数组有序。返回插入的数据项所在数组的索引
	 * @param insertItem
	 * @return
	 */
	public int insertItem(DataItem insertItem) {
		// assumes node is not full
		numItems++;
		long insertKey = insertItem.dData;

		for (int j = ORDER - 2; j >= 0; j--) {
			if (itemArray[j] == null)
				continue;
			else {
				long itsKey = itemArray[j].dData;
				if (insertKey < itsKey)
					itemArray[j + 1] = itemArray[j];
				else {
					itemArray[j + 1] = insertItem;
					return j + 1;
				}
			} // end else
		} // end for

		// 所有数据比新插入的数据值大，移动其他数据后，在0索引插入数据项。
		itemArray[0] = insertItem;
		return 0;
	}

	/**
	 * 	删除最右端数据项，返回删除对象。
	 * @return
	 */
	public DataItem removeItem() {
		// assumes node not empty
		DataItem temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}
	
	public void displayNode() {
		for (int j = 0; j < numItems; j++)
			itemArray[j].displayItem();
		System.out.println("/");
	}
}
