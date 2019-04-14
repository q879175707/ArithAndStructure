package arithAndStruct.tree._234Tree;

public class Tree234 {
	private Node root = new Node();

	/**
	 * 查找给定的key值，如果找到返回所在数组的索引，如果没有找到返回-1。
	 * 
	 * @param key
	 * @return
	 */
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			// 如果在当前节点找到对应的值，返回当前节点数据项所在数组的索引
			if ((childNumber = curNode.findItem(key)) != -1)
				return childNumber;
			// 如果当前节点是叶节点，返回-1
			else if (curNode.isLeaf())
				return -1;
			// 当前节点 = 下一个子节点
			else
				curNode = getNextChild(curNode, key);
		}
	}

	/**
	 * 根据给定的值，查找当前节点四个子节点中，存放给定值的那个子节点。
	 * 
	 * @param theNode  当前节点
	 * @param theValue 查找的值
	 * @return
	 */
	public Node getNextChild(Node theNode, long theValue) {
		int j;
		// assumes node is not empty, not full, not a leaf
		int numItems = theNode.getNumItems();
		for (j = 0; j < numItems; j++) {
			// 如果查找的值小于当前节点的第j个值
			if (theValue < theNode.getItem(j).dData)
				return theNode.getChild(j);
		}
		// 如果要查找的值大于当前节点的所有的值，返回数据项j + 1处的子节点。
		return theNode.getChild(j);
	}

	/**
	 * 	向树中插入值
	 * @param dValue
	 */
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		// 如果当前节点是满节点，那么就分裂。
		// 查找下一个适合的子节点。
		// 如果当前节点是叶节点。退出循环。
		while (true) {
			if (curNode.isFull()) {
				split(curNode);
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, dValue);
			} else if (curNode.isLeaf())
				break;
			else
				curNode = getNextChild(curNode, dValue);
		} // end while
		
		// 在叶节中插入数据项
		curNode.insertItem(tempItem);
	}

	/**
	 * 	节点分裂 
	 * 		如果寻找要插入位置的路途中，节点已经满了，节点必须分裂。正是这种分裂过程保证了树的平衡。
	 * 		把要分裂节点中的数据项设为A、B、C。（假设正在分裂的节点不是根） 
	 * 		1.创建一个新的空节点。它是要分裂节点的兄弟，在要分裂节点的右边。
	 * 		2.数据项C移到新节点中。 
	 * 		3.数据项B移到要分裂节点的父节点中。 
	 * 		4.数据项A保留在原来的位置上。
	 * 		5.最右边的两个子节点从要分裂节点处断开，连到新节点上。 插入只需要分裂一个节点，除非插入路径上存在不止一个满的节点。这种情况就需要多重分裂。 
	 * 	根的分裂
	 * 		如果一开始查找插入点时就碰到满的根时，插入过程更复杂一点： 
	 * 		1.创建新的根。它是要分裂节点的父节点。
	 * 	 	2.创建第二个新的节点。它是要分裂节点的兄弟节点。
	 * 		3.数据项C移到新的兄弟节点中。
	 *  	4.数据项B移到新的根节点中。
	 *  	5.数据项A保留在原来的位置上。
	 * 		6.要分裂节点最右边的两个子节点断开连接，连到新的兄弟节点中。
	 * 
	 * @param thisNode
	 */
	public void split(Node thisNode) {
		// assumes node is full
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;

		itemC = thisNode.removeItem();
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);
		Node newRight = new Node();

		// 如果节点是根节点。
		if (thisNode == root) {
			root = new Node();
			parent = root;
			// 连接0位置的子节点
			root.connectChild(0, thisNode);
		} else
			parent = thisNode.getParent();

		// 将数据项B插入到父节点
		itemIndex = parent.insertItem(itemB);
		// 返回父节点数据项的数目
		int n = parent.getNumItems();
		
		// 如果在父节点中有比插入的数据项B 大的数据（插入B会使它右移），断开原来的子节点，
		// 重新设置正确的子节点位置。子节点也要相应的右移
		for (int j = n; j > itemIndex; j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}

		// 父节点连接新建的子节点(新建的兄弟节点),位置是ItemIndex+1
		parent.connectChild(itemIndex + 1, newRight);

		// itemC插入到右边的兄弟节点
		newRight.insertItem(itemC);
		// 兄弟节点连接源节点的最右边两个节点
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}

	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}

	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level = " + level + " child = " + childNumber + " ");
		thisNode.displayNode();

		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++) {
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null)
				recDisplayTree(nextNode, level + 1, j);
			else
				return;
		}
	}
}
