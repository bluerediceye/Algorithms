package com.algorithms.amazon9.sde2;

import java.util.*;

/**
 * Created on 03/03/2017
 *
 * @author Ming Li
 */
public class FindOrderDependency {
    static class Order {
        String orderName;

        public Order(String orderName) {
            this.orderName = orderName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Order order = (Order) o;

            return orderName != null ? orderName.equals(order.orderName) : order.orderName == null;
        }

        @Override
        public int hashCode() {
            return orderName != null ? orderName.hashCode() : 0;
        }

        @Override
        public String toString() {
            return orderName;
        }
    }

    static class OrderDependency {
        Order order;
        Order dependent;

        public OrderDependency(Order order, Order dependent) {
            this.order = order;
            this.dependent = dependent;
        }
    }

    public static List<Order> findOrder(List<OrderDependency> dependencies) {
        Map<String, Integer> inmap = new HashMap<>(); // 存储入度
        Map<String, List<String>> outmap = new HashMap<>(); // 存储邻接节点
        for (OrderDependency i : dependencies) {
            if (!inmap.containsKey(i.dependent.orderName)) inmap.put(i.dependent.orderName, 0);
            if (!inmap.containsKey(i.order.orderName)) inmap.put(i.order.orderName, 0);
            inmap.put(i.order.orderName, inmap.get(i.order.orderName) + 1);//入度

            if (!outmap.containsKey(i.dependent.orderName)) outmap.put(i.dependent.orderName, new ArrayList<String>());
            outmap.get(i.dependent.orderName).add(i.order.orderName);//邻接节点
        }
        List<Order> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (String i : inmap.keySet()) {
            if (inmap.get(i) == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            String s = queue.poll();
            res.add(new Order(s));
            if (outmap.containsKey(s)) {
                for (String o : outmap.get(s)) {
                    inmap.put(o, inmap.get(o) - 1);
                    if (inmap.get(o) == 0) queue.offer(o);
                }
            }
            outmap.remove(s);
        }
        return res;
    }


    //leetcode
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjLists.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int x : adjLists.get(i)) {
                indegrees[x]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int x : adjLists.get(cur)) {
                indegrees[x]--;
                if (indegrees[x] == 0) {
                    queue.offer(x);
                }
            }
            res[count++] = cur;
        }

        if (count == numCourses) return res;
        return new int[0];
    }

    public static void main(String[] args) {
        List<OrderDependency> input = new ArrayList<>();
        input.add(new OrderDependency(new Order("A"), new Order("E")));
//        input.add(new OrderDependency(new Order("E"), new Order("A")));
        input.add(new OrderDependency(new Order("D"), new Order("E")));
        input.add(new OrderDependency(new Order("A"), new Order("C")));
        input.add(new OrderDependency(new Order("B"), new Order("D")));
        List<Order> output = findOrder(input);
        List<Order> output2 = findDependencies(input);
        for (Order i : output) System.out.print(i.orderName + " ");
        System.out.println();
        for (Order i : output2) System.out.print(i.orderName + " ");
    }

    public static List<Order> findDependencies(List<OrderDependency> dependencies) {
        if (dependencies == null || dependencies.isEmpty()) {
            return null;
        }

        Map<Order, Integer> indegrees = new HashMap<>();
        Map<Order, List<Order>> adjOrders = new HashMap<>();

        for (OrderDependency orderDependency : dependencies) {

            if (!indegrees.containsKey(orderDependency.dependent)) {
                indegrees.put(orderDependency.dependent, 0);
            }
            if (!indegrees.containsKey(orderDependency.order)) {
                indegrees.put(orderDependency.order, 1);
            } else {
                indegrees.put(orderDependency.order, indegrees.get(orderDependency.order) + 1);
            }
            if (!adjOrders.containsKey(orderDependency.dependent)) {
                adjOrders.put(orderDependency.dependent, new ArrayList<>());
            }
            adjOrders.get(orderDependency.dependent).add(orderDependency.order);
        }

        Queue<Order> queue = new LinkedList<Order>();
        List<Order> result = new ArrayList<>();

        for (Map.Entry<Order, Integer> entry : indegrees.entrySet()) {
            if (indegrees.get(entry.getKey()) == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {

            Order order = queue.poll();
            result.add(order);

            if (adjOrders.containsKey(order)) {
                for (Order o : adjOrders.get(order)) {
                    indegrees.put(o, indegrees.get(o) - 1);
                    if (indegrees.get(o) == 0) {
                        queue.offer(o);
                    }
                }
                adjOrders.remove(order);
            }
        }

        return result;
    }
}
