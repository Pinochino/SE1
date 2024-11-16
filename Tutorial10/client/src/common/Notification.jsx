const successMessage = (content) => (
    <div className="alert alert-success" role="alert">
        {content}
    </div>
)

const errorMessage = (content) => (
    <div className="alert alert-danger" role="alert">
       {content}
    </div>
)
function Notification({success, fail, content}) {

    return (
        <div>
            {success && successMessage(content)}
            {fail && errorMessage(content)}
        </div>);
}

export default Notification;