package com.example.photooftheday.repository;

import com.example.photooftheday.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CommentRepository implements ICommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(int id) {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c where c.id = :id", Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Comment object) {
        if (object.getId() == 0) {
            entityManager.persist(object);
        } else {
            entityManager.merge(object);
        }
    }

    @Override
    public void delete(int id) {
        Comment comment = findById(id);
        if (comment != null) {
            entityManager.remove(comment);
        }
    }
}
