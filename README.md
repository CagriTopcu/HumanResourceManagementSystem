# Human Resource Management System

# PostgreSQL Database Tables

## :pushpin: Candidates
<table>
    <thead>
        <tr> 
            <th>user_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>identity_number</th>
            <th>year_of_birth</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Çağrı</td>
            <td>Topçu</td>
            <td>12345678910</td>
            <td>22.02.1999</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

## :pushpin: Employers

<table>
    <thead>
        <tr>
            <th>user_id</th>
            <th>company_name</th>
            <th>website</th>
            <th>phone</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>2</td>
            <td>Kodlama.io</td>
            <td>kodlama.io</td>
            <td>123456789</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

## :pushpin: Employers Verifications

<table>
    <thead>
        <tr>
            <th>employer_id</th>
            <th>confirm</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>2</td>
            <td>false</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

## :pushpin: Job Positions

<table>
    <thead>
        <tr>
            <th>job_position_id</th>
            <th>name</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Software Developer</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Full Stack Developer</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>3</td>
            <td>Front End Developer</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

## :pushpin: System Employees

<table>
    <thead>
        <tr>
            <th>user_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Çağrı</td>
            <td>Topçu</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

## :pushpin: Users

<table>
    <thead>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>password</th>
            <th>confirm_password</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>example@example.com</td>
            <td>12345678</td>
            <td>12345678</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>2</td>
            <td>kodlamaio@kodlamaio.com</td>
            <td>12345678</td>
            <td>12345678</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

## :pushpin: Verifications

<table>
    <thead>
        <tr>
            <th>user_id</th>
            <th>confirm</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>true</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>2</td>
            <td>false</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>
