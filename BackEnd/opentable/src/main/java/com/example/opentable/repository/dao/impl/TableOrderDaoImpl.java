package com.example.opentable.repository.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.TableOrderDao;
import com.example.opentable.repository.entity.TableOrder;

@Repository
public class TableOrderDaoImpl extends AbstractParentDao<TableOrder> implements TableOrderDao{

}