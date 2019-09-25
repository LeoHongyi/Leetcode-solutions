package tree.binaryTree;

import algorithms.tree.binaryTree.CheckCousin;
import algorithms.tree.binaryTree.TreeNode;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/** Example:
 *
 *                       6
 *
 *                   /     \
 *
 *                3            5
 *
 *             /     \      /    \
 *
 *          7         8    1       2
 * 7 and 1, result is TRUE
 * 3 and 5, result is FALSE
 * 7 and 5, result is FALSE
 **/
public class CheckCousinTest {
	CheckCousin cc;
	static TreeNode one = new TreeNode(1);
	static TreeNode two = new TreeNode(2);
	static TreeNode three = new TreeNode(3);
	static TreeNode five = new TreeNode(5);
	static TreeNode six = new TreeNode(6);
	static TreeNode seven = new TreeNode(7);
	static TreeNode eight = new TreeNode(8);

	@BeforeClass
	public static void setUpClass() {
		six.left = three;
		six.right = five;
		three.left = seven;
		three.right = eight;
		five.left = one;
		five.right = two;
	}
	@Before
	public void setUp() {
		cc = new CheckCousin();
	}
	@Test
	public void test1() {
		assertTrue(cc.checkCousin(six, seven, one));
	}
	@Test
	public void test2() {
		assertFalse(cc.checkCousin(six, three, five));
	}
	@Test
	public void test3() {
		assertFalse(cc.checkCousin(six, seven, five));
	}
}