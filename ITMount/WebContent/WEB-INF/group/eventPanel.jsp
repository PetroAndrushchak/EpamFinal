<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="resources/css/styleEvent.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/font-awesome.css"
	type="text/css">


<div class="panel panel-default">
	<div class="panel-heading">
		<c:if
			test="${not empty group.teacher_id && user.id == group.teacher_id}">
			<a data-toggle="modal" id="createEventModal" href="#createEvent"><i
				class='glyphicon glyphicon-plus'></i></a>
		</c:if>
		Events

	</div>
	<table class="table">
		<c:forEach items="${ events}" var="event" varStatus="loop">
			<tr>
				<td><c:out value="${event.date }" /></td>
				<td><c:out value="${event.description }" /></td>

				<c:if
					test="${not empty group.teacher_id && user.id == group.teacher_id}">
					<td><a data-toggle="modal" class='editEvent' id='${event.id }'
						href="#editEvent"><i class='glyphicon glyphicon-edit'></i></a></td>
					<td><a class='editEvent'
						href="<c:url value='EventServlet?action=delete&event_id=${event.id }' />"><i
							class='glyphicon glyphicon-minus'></i></a></td>
				</c:if>

			</tr>

		</c:forEach>
	</table>
</div>

<div class="ibox float-e-margins">
	<div class="ibox-title  panel panel-default">
		<h5>
			<c:if
				test="${not empty group.teacher_id && user.id == group.teacher_id}">
				<a data-toggle="modal" id="createEventModal" href="#createEvent"><i
					class='glyphicon glyphicon-plus'></i></a>
			</c:if>
			Events

		</h5>
		<div class="ibox-tools">
			<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
			</a>
		</div>

	</div>

	<div class="ibox-content inspinia-timeline">
		<c:forEach items="${ events}" var="event" varStatus="loop">
			<div class="timeline-item">
				<div class="row">
					<div class="col-xs-3 date">
						<i class="${event.typeEvent }"></i> 
						<fmt:formatDate pattern="yyyy-MM-dd" value="${event.date }" />
						<fmt:formatDate pattern="hh:mm" value="${event.date }" />
						 <br /> <small
							class="text-navy">${event.message }</small>

						
					</div>
					<div class="col-xs-7 content no-top-border">
						<p class="m-b-xs">
							<strong>${event.nameEvent }</strong>
						</p>

						<p>${event.description }</p>


					</div>
					<div class="col-xs-2 content no-top-border">
						<p class="m-b-xs">
							<strong>Options</strong>
						</p>

						<c:if
							test="${not empty group.teacher_id && user.id == group.teacher_id}">
							<td><a data-toggle="modal" class='editEvent'
								id='${event.id }' href="#editEvent"><i
									class='glyphicon glyphicon-edit'></i></a></td>
							<td><a class='editEvent'
								href="<c:url value='EventServlet?action=delete&event_id=${event.id }' />"><i
									class='glyphicon glyphicon-minus'></i></a></td>
						</c:if>


					</div>

				</div>
			</div>
		</c:forEach>

	</div>
</div>



<div id="createEvent" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">New event</h4>
			</div>
			<div class="modal-body">
				<form action="EventServlet?action=create" id='create-event-form'
					method="post" role="form" role="form">

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Event
								Name</b></label> <input name="eventName" class="form-control" id="eventName"
							type="text" required="required" placeholder="">
					</div>

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Event
								Type</b></label> <select class="form-control " name="typeEvent" id="sel1">
							<option value="fa fa-calendar">other</option>
							<option value="fa fa-birthday-cake">birthday</option>
							<option value="fa fa-beer">beer</option>
							<option value="fa fa-futbol-o">sport</option>
							<option value="fa fa-coffee">coffee</option>
							<option value="fa fa-camera">foto</option>
							<option value="fa fa-tree">holiday</option>
							<option value="fa fa-usd">money</option>

						</select>
					</div>


					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Event
								Description</b></label>
						<textarea name="description" class="form-control" type="text"
							placeholder=""></textarea>
					</div>

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Date</b></label>
						<input name="date" class="form-control" id="comment"
							type="datetime-local" required="required" placeholder="">
					</div>

					<div class="form-group" hidden="true">

						<input name="group_id" class="form-control" id="login-username"
							type="text" placeholder="" value="${group.id }">
					</div>
					<div class="form-group">

						<button type="submit" id='submit-event-create'
							class="btn pull-right">Add</button>
						<div class="clearfix"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	/* $('form[data-async]').on('submit', function(event) {
		var $form = $(this);
		var $target = $($form.attr('data-target'));

		$.ajax({
			type : $form.attr('method'),
			url : $form.attr('action'),
			data : $form.serialize(),

			success : function(data, status) {
				var $tr = $("<tr>");
				var $td1 = $("<td>");
				var $td2 = $("<td>");
				var $td3 = $("<td>");
				
				
				$td1.val(<c:out value="${event.date }" />);
				$td2.val(<c:out value="${event.description }" />);
				
				$tr.append($td1);
				$tr.append($td2);
				$tr.append($td3);
				$('.eventTable').prepend($tr);
			}
		});

		event.preventDefault();
	});

	$('button#submit-event-create').click(function() {
		$('#createEvent').modal('hide');
	}); */
</script>


<div id="editEvent" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Update Event</h4>
			</div>
			<div class="modal-body">
				<form action="EventServlet?action=update" id='create-event-form'
					method="post" role="form" role="form">

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Event
								Name</b></label> <input name="eventName" class="form-control"
							id="eventName1" type="text" required="required" placeholder="">
					</div>

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Event
								Type</b></label> <select class="form-control " name="typeEvent"
							id="eventType">
							<option value="fa fa-calendar">other</option>
							<option value="fa fa-birthday-cake">birthday</option>
							<option value="fa fa-beer">beer</option>
							<option value="fa fa-futbol-o">sport</option>
							<option value="fa fa-coffee">coffee</option>
							<option value="fa fa-camera">foto</option>
							<option value="fa fa-tree">holiday</option>
							<option value="fa fa-usd">money</option>

						</select>
					</div>

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Event
								Description</b></label>
						<textarea name="description" id="eventDescription"
							class="form-control" type="text" placeholder=""></textarea>
					</div>

					<div class="form-group">
						<label for="login-password"><i class="icon-lock"></i> <b>Date</b></label>
						<input name="date" class="form-control" id="eventDate"
							type="datetime-local" required="required" placeholder="">
					</div>

					<div class="form-group" hidden="true">

						<input name="group_id" class="form-control" id="login-username"
							type="text" placeholder="" value="${group.id }">
					</div>
					<div class="form-group" hidden="true">

						<input name="event_id" class="form-control" id="event_id"
							type="text" placeholder="">
					</div>
					<div class="form-group">

						<button type="submit" id='submit-event-create'
							class="btn pull-right">Update</button>
						<div class="clearfix"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('a.editEvent').click(
			function() {
				var index = $(this).attr('id');
				$("#event_id").val(index);
				$.get('EventServlet?action=show&event_id=' + index, function(
						response) {

					$('#eventDescription').val(response.description);

					var dateString = response.date;
					// 			var dateStringTest = "1996-12-19T16:39";

					var date = new Date(Date.parse(dateString));

					var year = date.getFullYear().toString();
					var month = addZero(date.getMonth() + 1).toString();
					var day = addZero(date.getDate()).toString();
					var hours = addZero(date.getHours()).toString();
					var minutes = addZero(date.getMinutes()).toString();

					var correctDate = year.concat("-", month, "-", day, "T",
							hours, ":", minutes);

					$("#eventDate").val(correctDate);

					$('#eventName1').val(response.nameEvent);
					$('#eventType').val(response.typeEvent);
				});
			});

	function addZero(i) {
		if (i < 10) {
			i = "0" + i;
		}
		return i;
	}
</script>




