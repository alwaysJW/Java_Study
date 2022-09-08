package com.pas.service.Impl;

import com.pas.dao.CarDao;
import com.pas.dao.Impl.CarDaoImpl;
import com.pas.domain.Car;
import com.pas.domain.PageBean;
import com.pas.service.CarService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class CarServiceImpl implements CarService {
    private final CarDao dao = new CarDaoImpl();
    @Override
    public PageBean<Car> findCarByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        //创建空对象
        PageBean<Car> pb = new PageBean<>();
        //设置参数
        //查询总记录数
        int totalCount = dao.findTotalCount(condition);
        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : ((totalCount / rows) + 1);
        if (currentPage >= totalPage){
            currentPage =totalPage;
        }
        //查询List集合
        //计算开始记录索引
        int start = (currentPage - 1) * rows;
        List<Car> list = dao.findByPage(start, rows, condition);
        pb.setTotalPage(totalPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }

    @Override
    public void addCar(Car car) {
        car.setIntime(new Timestamp(System.currentTimeMillis()));
        dao.addCar(car);
    }

    @Override
    public Car findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateCar(Car car) {
        car.setIntime(new Timestamp(System.currentTimeMillis()));
        dao.updateCar(car);
    }

    @Override
    public void deleteCar(String id) {
        dao.deleteCar(Integer.parseInt(id));
    }

    @Override
    public void outCar(String id) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        dao.deleteCar(Integer.parseInt(id),time);
    }
}
