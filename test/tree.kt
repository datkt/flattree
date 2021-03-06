package datkt.flattree.test

import datkt.flattree.Tree
import datkt.tape.Test
import datkt.tape.test

fun tree(argv: Array<String>) {
  val tree = Tree()

  test("tree.parents", fun(t: Test) {
    t.equal(1L, tree.parent(0L, null), "1L, tree.parent(0L, null)")
    t.equal(1L, tree.parent(2L, null), "1L, tree.parent(2L, null)")
    t.equal(3L, tree.parent(1L, null), "3L, tree.parent(1L, null)")

    t.end()
  })

  test("tree.children", fun(t: Test) {
    val children0 = tree.children(0L, null)
    t.equal(0, children0.size, "0 size array, tree.children(0L, null)")

    val children1 = tree.children(1L, null)
    t.equal(0L, children1[0], "arrayOf(0L, 2L)[0], tree.children(1L, null)")
    t.equal(2L, children1[1], "arrayOf(0L, 2L)[1], tree.children(1L, null)")

    val children2 = tree.children(3L, null)
    t.equal(1L, children2[0], "arrayOf(1L, 5L)[0], tree.children(3L, null)")
    t.equal(5L, children2[1], "arrayOf(1L, 5L)[1], tree.children(3L, null)")

    val children3 = tree.children(9L, null)
    t.equal(8L, children3[0], "arrayOf(9L, null)[0], tree.children(9L, null)")
    t.equal(10L, children3[1], "arrayOf(9L, null)[1], tree.children(9L, null)")

    t.end()
  })

  test("tree.leftChild", fun(t: Test) {
    t.equal(-1L, tree.leftChild(0L, null), "-1L, tree.leftChild(0L, null)")
    t.equal(0L, tree.leftChild(1L, null), "0L, tree.leftChild(1L, null)")
    t.equal(1L, tree.leftChild(3L, null), "1L, tree.leftChild(3L, null)")

    t.end()
  })

  test("tree.rightChild", fun(t: Test) {
    t.equal(-1L, tree.rightChild(0L, null), "-1L, tree.rightChild(0L, null)")
    t.equal(2L, tree.rightChild(1L, null), "2L, tree.rightChild(1L, null)")
    t.equal(5L, tree.rightChild(3L, null), "5L, tree.rightChild(3L, null)")

    t.end()
  })

  test("tree.siblings", fun(t: Test) {
    t.equal(2L, tree.sibling(0L, null), "2L, tree.sibling(0L, null)")
    t.equal(0L, tree.sibling(2L, null), "0L, tree.sibling(2L, null)")
    t.equal(5L, tree.sibling(1L, null), "5L, tree.sibling(1L, null)")
    t.equal(1L, tree.sibling(5L, null), "1L, tree.sibling(5L, null)")

    t.end()
  })

  test("fullRoots", fun(t: Test) {
    val full0 = tree.fullRoots(0L, null)
    t.equal(0, full0.size, "arrayOf<Long>(), tree.fullRoots(0L, null)")
    val full1 = tree.fullRoots(2L, null)
    t.equal(0L, full1[0], "arrayOf(0L), tree.fullRoots(2L, null)")
    val full2 = tree.fullRoots(8L, null)
    t.equal(3L, full2[0], "arrayOf(3L), tree.fullRoots(8L, null)")
    val full3 = tree.fullRoots(20L, null)
    t.equal(7L, full3[0], "arrayOf(7L, 17L), tree.fullRoots(20L, null)")
    t.equal(17L, full3[1], "arrayOf(7L, 17L), tree.fullRoots(20L, null)")
    val full4 = tree.fullRoots(18L, null)
    t.equal(7L, full4[0], "arrayOf(7L, 16L), tree.fullRoots(18L, null)")
    t.equal(16L, full4[1], "arrayOf(7L, 16L), tree.fullRoots(18L, null)")
    val full5 =  tree.fullRoots(16L, null)
    t.equal(7L, full5[0], "arrayOf(7L), tree.fullRoots(16L, null)")

    t.end()
  })

  test("tree.spans", fun(t: Test) {
    val spans1 = tree.spans(0L, null)
    t.equal(0L, spans1[0], "arrayOf(0L, 0L), tree.spans(0L, null)")
    t.equal(0L, spans1[1], "arrayOf(0L, 0L), tree.spans(0L, null)")

    val spans2 = tree.spans(1L, null)
    t.equal(0L, spans2[0], "arrayOf(0L, 2L), tree.spans(1L, null)")
    t.equal(2L, spans2[1], "arrayOf(0L, 2L), tree.spans(1L, null)")

    val spans3 = tree.spans(3L, null)
    t.equal(0L, spans3[0], "arrayOf(0L, 6L), tree.spans(3L, null)")
    t.equal(6L, spans3[1], "arrayOf(0L, 6L), tree.spans(3L, null)")

    val spans4 = tree.spans(23L, null)
    t.equal(16L, spans4[0], "arrayOf(16L, 30L), tree.spans(23L, null)")
    t.equal(30L, spans4[1], "arrayOf(16L, 30L), tree.spans(23L, null)")

    val spans5 = tree.spans(27L, null)
    t.equal(24L, spans5[0], "arrayOf(24L, 30L), tree.spans(27L, null)")
    t.equal(30L, spans5[1], "arrayOf(24L, 30L), tree.spans(27L, null)")

    t.end()
  })

  test("tree.leftSpan", fun(t: Test) {
    t.equal(0L, tree.leftSpan(0L, null), "0L, tree.leftSpan(0L, null)")
    t.equal(0L, tree.leftSpan(1L, null), "0L, tree.leftSpan(1L, null)")
    t.equal(0L, tree.leftSpan(3L, null), "0L, tree.leftSpan(3L, null)")
    t.equal(16L, tree.leftSpan(23L, null), "16L, tree.leftSpan(23L, null)")
    t.equal(24L, tree.leftSpan(27L, null), "24L, tree.leftSpan(27L)")

    t.end()
  })

  test("tree.rightSpan", fun(t: Test) {
    t.equal(0L, tree.rightSpan(0L, null), "0L, tree.rightSpan(0L, null)")
    t.equal(2L, tree.rightSpan(1L, null), "2L, tree.rightSpan(1L, null)")
    t.equal(6L, tree.rightSpan(3L, null), "6L, tree.rightSpan(3L, null)")
    t.equal(30L, tree.rightSpan(23L, null), "30L, tree.rightSpan(23L, null)")
    t.equal(30L, tree.rightSpan(27L, null), "30L, tree.rightSpan(27L, null)")

    t.end()
  })

  test("tree.count", fun(t: Test) {
    t.equal(1L, tree.count(0L, null), "1L, tree.count(0L, null)")
    t.equal(3L, tree.count(1L, null), "3L, tree.count(1L, null)")
    t.equal(7L, tree.count(3L, null), "7L, tree.count(3L, null)")
    t.equal(3L, tree.count(5L, null), "3L, tree.count(5L, null)")
    t.equal(15L, tree.count(23L, null), "15L, tree.count(23L, null)")
    t.equal(7L, tree.count(27L, null), "7L, tree.count(27L, null)")

    t.end()
  })

  test("parent > int32", fun(t: Test) {
    t.equal(10000000001L, tree.parent(10000000000L, null), "10000000001L, tree.parent(10000000000L)")
    t.end()
  })

  test("child to parent to child", fun(t: Test) {
    var child: Long = 0
    for (i in 0..49) child = tree.parent(child, null)
    t.equal(1125899906842623L, child, "1125899906842623L, child")
    for (j in 0..49) child = tree.leftChild(child, null)
    t.equal(0L, child, "0L, child")

    t.end()
  })
}
