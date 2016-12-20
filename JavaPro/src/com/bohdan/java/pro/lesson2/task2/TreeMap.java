package com.bohdan.java.pro.lesson2.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bohdan on 18.12.2016.
 */
public class TreeMap<K extends Comparable<K>, V>
{
    private static final Logger logger = LoggerFactory.getLogger(TreeMap.class);

    private Node rootNode;
    private Node leftmostNode;
    private Node rightmostNode;

    public Node getRootNode()
    {
        return rootNode;
    }

    public boolean add(K key, V value)
    {
        Node node = new Node(key, value);

        if (rootNode == null)
        {
            rootNode = node;
            return true;
        }

        return rootNode.addChild(node);
    }

    private Node findNode(K key, Node nodeFrom)
    {
        if (key.compareTo(nodeFrom.getKey()) == 0)
        {
            return nodeFrom;
        }

        if (key.compareTo(nodeFrom.getKey()) < 0 && nodeFrom.getLeftChild() != null)
        {
            return findNode(key, nodeFrom.getLeftChild());
        }

        if (key.compareTo(nodeFrom.getKey()) > 0 && nodeFrom.getRightChild() != null)
        {
            return findNode(key, nodeFrom.getRightChild());
        }

        return null;
    }

    public boolean find(K key)
    {
        logger.debug("Finding node with key {}", key);

        if (findNode(key, rootNode) != null)
        {
            return true;
        }

        return false;
    }

    public V get(K key)
    {
        logger.debug("Getting node value with key {}", key);

        Node node = findNode(key, rootNode);

        if (node != null)
        {
            return node.getValue();
        }

        return null;
    }

    public Node getNode(K key)
    {
        logger.debug("Getting node with key {}", key);

        Node node = findNode(key, rootNode);

        if (node != null)
        {
            return node;
        }

        return null;
    }

    private Node getLeftmostNode(Node nodeFrom)
    {
        if (nodeFrom.getLeftChild() == null)
        {
            return nodeFrom;
        }

        return getLeftmostNode(nodeFrom.getLeftChild());
    }

    public V remove(K key)
    {
        logger.debug("Removing node with key {}", key);

        Node nodeToRemove = findNode(key, rootNode);

        if (nodeToRemove == null)
        {
            return null;
        }

        nodeToRemove.getParent().setLeftChild(nodeToRemove.getRightChild());

        Node leftmostNode = getLeftmostNode(nodeToRemove.getRightChild());
        leftmostNode.setLeftChild(nodeToRemove.getLeftChild());

        return nodeToRemove.getValue();
    }

    private void addChildNodesToSet(Node parentNode, Set<Node> nodes)
    {
        if (parentNode.getLeftChild() != null)
        {
            nodes.add(parentNode.getLeftChild());
            addChildNodesToSet(parentNode.getLeftChild(), nodes);
        }

        if (parentNode.getRightChild() != null)
        {
            nodes.add(parentNode.getRightChild());
            addChildNodesToSet(parentNode.getRightChild(), nodes);
        }
    }

    public Set<Node> getNodes()
    {
        Set<Node> nodes = new HashSet<>();

        nodes.add(rootNode);
        addChildNodesToSet(rootNode, nodes);

        return nodes;
    }

    private void addChildNodesKeysToSetByValue(Node parentNode, Set<K> keys, V value)
    {
        if (parentNode.getLeftChild() != null)
        {
            if (parentNode.getLeftChild().getValue().equals(value))
            {
                keys.add(parentNode.getLeftChild().getKey());
            }
            addChildNodesKeysToSetByValue(parentNode.getLeftChild(), keys, value);
        }

        if (parentNode.getRightChild() != null)
        {
            if (parentNode.getRightChild().getValue().equals(value))
            {
                keys.add(parentNode.getRightChild().getKey());
            }
            addChildNodesKeysToSetByValue(parentNode.getRightChild(), keys, value);
        }
    }

    public Set<K> contains(V value)
    {
        Set<K> keys = new HashSet<>();

        if (rootNode.getValue().equals(value))
        {
            keys.add(rootNode.getKey());
        }
        addChildNodesKeysToSetByValue(rootNode, keys, value);

        return keys;
    }

    private class Node implements Comparable<Node>
    {
        private K key;
        private V value;

        private Node parent;
        private Node leftChild;
        private Node rightChild;

        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
            return value;
        }

        public Node getParent()
        {
            return parent;
        }

        public Node getLeftChild()
        {
            return leftChild;
        }

        public Node getRightChild()
        {
            return rightChild;
        }

        public void setKey(K key)
        {
            this.key = key;
        }

        public void setValue(V value)
        {
            this.value = value;
        }

        public void setParent(Node parent)
        {
            this.parent = parent;
        }

        public void setLeftChild(Node leftChild)
        {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild)
        {
            this.rightChild = rightChild;
        }

        public boolean addChild(Node node)
        {
            if (compareTo(node) == 0)
            {
                return false;
            }

            if (compareTo(node) < 0)
            {
                addLeftChild(node);
            }

            if (compareTo(node) > 0)
            {
                addRightChild(node);
            }

            return true;
        }

        public boolean addLeftChild(Node node)
        {
            if (leftChild != null)
            {
                return leftChild.addChild(node);
            }

            node.parent = this;
            leftChild = node;
            leftmostNode = node;
            return true;
        }

        public boolean addRightChild(Node node)
        {
            if (rightChild != null)
            {
                return rightChild.addChild(node);
            }

            node.parent = this;
            rightChild = node;
            rightmostNode = rightChild;
            return true;
        }

        @Override
        public int compareTo(Node o)
        {
            return o.key.compareTo(key);
        }

        @Override
        public String toString()
        {
            return key + "\t" + value;
        }
    }
}
