<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="addUserToGroup" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Add user to group</h4>
			</div>
			<div class="modal-body">
				<div class="form-group" hidden="true">
					<input name="group_id" class="form-control" id="group-id-edit"
						type="text" placeholder="" value="${group.id }">
				</div>

				<div class="form-group" id='message-subject'>
					<label for="login-username"><i class="icon-user"></i> <b>Message
							subject</b></label> <input name="subject" class="form-control"
						id="group-name-edit" type="text" placeholder="">
				</div>

				<div class="form-group" id='passed'>
					<label for="login-username"><i class="icon-user"></i> <b>
							Message</b></label>
					<textarea name="message" class="form-control" id="group-name-edit"
						placeholder=""></textarea>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary pull-right" name="action"
						value="add">Add Users</button>
					<div class="clearfix"></div>
				</div>

			</div>
		</div>
	</div>
</div>