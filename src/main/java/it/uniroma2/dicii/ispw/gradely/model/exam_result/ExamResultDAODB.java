package it.uniroma2.dicii.ispw.gradely.model.exam_result;

import it.uniroma2.dicii.ispw.gradely.dao_abstract.DAODBAbstract;
import it.uniroma2.dicii.ispw.gradely.exceptions.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExamResultDAODB extends DAODBAbstract<ExamResult> implements ExamResultDAOInterface {
    protected static ExamResultDAOInterface instance;

    private ExamResultDAODB(){ 

    }

    public static synchronized ExamResultDAOInterface getInstance(){
        if (instance == null){
            instance = new ExamResultDAODB();
        }
        return instance;
    }



    @Override
    public void insert(ExamResult examResult) throws DAOException {

    }

    @Override
    public void cancel(ExamResult examResult) throws DAOException {

    }

    @Override
    public void update(ExamResult examResult) throws DAOException {

    }

    @Override
    protected void setInsertQueryParametersValue(PreparedStatement stmt, ExamResult examResult) throws SQLException {

    }

    @Override
    protected void setUpdateQueryParametersValue(PreparedStatement stmt, ExamResult examResult) throws SQLException, MissingAuthorizationException {

    }




    @Override
    protected String setGetListQueryIdentifiersValue(ExamResult examResult, int valueNumber) throws DAOException {
        return null;
    }



}